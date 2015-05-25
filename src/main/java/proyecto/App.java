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
                return modelAndView(new HashMap<>(), "");
            }
        });

        get(new FreeMarkerRoute("/user/delete/:user_id") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                int id = Integer.parseInt(request.params(":user_id"));

                DAO.BorrarLibro(id);

                response.redirect("/");
                return modelAndView(new HashMap<>(), "");
            }
        });

        get(new FreeMarkerRoute("/user/create") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                Map<String, Object> data = new HashMap<>();

                data.put("jumbotron", "Insertar Libro");
                data.put("action", "/user/create");
                data.put("titulo", "");
                data.put("autor", "");
                data.put("editorial", "");
                data.put("isbn", "");
                return modelAndView(data, "user.ftl");
            }
        });

        post(new FreeMarkerRoute("/user/create") {
            @Override
            public ModelAndView handle(Request request, Response response) {

                String titulo = request.queryParams("titulo");
                String autor = request.queryParams("autor");
                String editorial = request.queryParams("editorial");
                String isbn = request.queryParams("isbn");

                DAO.InsertarLibro(new Libro(0, titulo, autor, editorial, isbn));

                response.redirect("/");
                return modelAndView(new HashMap<>(), "");
            }
        });

        get(new FreeMarkerRoute("/user/update/:user_id") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                int id = Integer.parseInt(request.params(":user_id"));

                Map<String, Object> data = new HashMap<>();

                Libro libro = DAO.BuscarLibro(id);

                if (libro != null) {
                    data.put("jumbotron", "Editar Libro");
                    data.put("action", ("/user/update/" + id));
                    data.put("titulo", libro.getTitulo());
                    data.put("autor", libro.getAutor());
                    data.put("editorial", libro.getEditorial());
                    data.put("isbn", libro.getIsbn());
                    data.put("id", libro.getId());
                } else {
                    response.redirect("/");
                }

                return modelAndView(data, "user.ftl");
            }
        });

        post(new FreeMarkerRoute("/user/update/:user_id") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                int id = Integer.parseInt(request.params(":user_id"));

                String titulo = request.queryParams("titulo");
                String autor = request.queryParams("autor");
                String editorial = request.queryParams("editorial");
                String isbn = request.queryParams("isbn");

                DAO.ActualizarLibro(new Libro(id, titulo, autor, editorial, isbn));

                response.redirect("/");

                return modelAndView(new HashMap<>(), "");
            }
        });
    }
}
