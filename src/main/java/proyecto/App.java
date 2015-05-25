package proyecto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;
import static spark.Spark.get;
import static spark.Spark.post;
import spark.template.freemarker.FreeMarkerRoute;

/**
 * Hello world!
 *
 */
public class App {

    static List<Libro> libros = new ArrayList<>();

    public static void main(String[] args) {
        Spark.staticFileLocation("/public");

        get(new FreeMarkerRoute("/") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                Map<String, Object> data = new HashMap<>();
                try {
                    libros = DAO.ListarLibros();
                } catch (Exception ex) {
                    System.out.println("ERROR GENERAL en DAO.ListarLibros");
                }
                data.put("libros", libros);

                return modelAndView(data, "list.ftl");
            }
        });

        get(new FreeMarkerRoute("/redirecciona") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                response.redirect("/");
                return modelAndView(new HashMap<>(),"");
            }
        });

        get(new FreeMarkerRoute("/user/delete/:user_id") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                int id = Integer.parseInt(request.params(":user_id"));
                Map<String, Object> data = new HashMap<>();
                
                DAO.BorrarLibro(id);

                response.redirect("/");
                return modelAndView(new HashMap<>(),"");
            }
        });

        get(new FreeMarkerRoute("/user/create") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                return modelAndView(null, "userCreate.ftl");
            }
        });

        post(new FreeMarkerRoute("/user/create") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                Map<String, Object> data = new HashMap<>();

                String titulo = request.queryParams("titulo");
                String autor = request.queryParams("autor");
                String editorial = request.queryParams("editorial");
                String isbn = request.queryParams("isbn");

                DAO.InsertarLibro(new Libro(0, titulo, autor, editorial, isbn));

                response.redirect("/");
                return modelAndView(new HashMap<>(),"");
            }
        });

        /*get(new FreeMarkerRoute("/user/update/:user_id") {
        @Override
        public Object handle(Request request, Response response) {
        int id = Integer.parseInt(request.params(":user_id"));
        
        Map<String, Object> data = new HashMap<>();
        //data.put("user", users.get(id));
        data.put("id", id);
        return modelAndView(data, "userUpdate.ftl");
        }
        });
        
        post(new FreeMarkerRoute("/user/update/:user_id") {
        @Override
        public ModelAndView handle(Request request, Response response) {
        Map<String, Object> data = new HashMap<>();
        
        int id = Integer.parseInt(request.params(":user_id"));
        
        String fn = request.queryParams("firstname");
        String ln = request.queryParams("lastname");
        
        users.set(id, new User(fn, ln));
        
        data.put("users", users);
        return modelAndView(data, "userList.ftl");
        }
        });*/
    }
}
