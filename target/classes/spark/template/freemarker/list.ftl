	

<#include "base.ftl">

<#macro page_content>
<div class=container>
	<div class="jumbotron">
		<h1>Libros</h1>
	</div>

	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav">

				<li class="active"><a href="/"><i class="icon-th icon-black"></i> Listar</a></li>
				<li ><a href="/user/create"><i class="icon-plus-sign icon-black"></i> Crear</a></li>

			</ul>
		</div>
	</div>

	<table width="600" cellpadding="5" class="table table-hover table-bordered">
		<thead>
			<tr>
				<th scope="col">T&iacute;tulo</th>
				<th scope="col">Autor</th>
				<th scope="col">Editorial</th>
				<th scope="col">ISBN</th>
				<th scope="col">Acciones</th>
			</tr>
		</thead>

		<tbody>    
			<#list libros as libro>
  				<tr>
    				<td>${libro.titulo}</td>
    				<td>${libro.autor}</td>
    				<td>${libro.editorial}</td>
    				<td>${libro.isbn}</td>
    				<td>
				    	<a href="/user/update/${libro.id}">
    						<button type="button" class="btn btn-default btn-sm">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							</button>
						</a>
						<a href="/user/delete/${libro.id}">
							<button type="button" class="btn btn-default btn-sm">
								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							</button>
						</a>
					</td>
  				</tr>
  			</#list>
		</tbody>                    
 	</table>
</div><#--end container-->
</#macro>

<@display_page/>


