	

<#include "base.ftl">

<#macro page_content>
<div class=container>
	<div class="jumbotron">
		<h1>Libros</h1>
	</div>

	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav">

				<li class="active"><a href="/"><i class="icon-th icon-black"></i> Read</a></li>
				<li ><a href="/user/create"><i class="icon-plus-sign icon-black"></i> Create</a></li>

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
					<tr>            
						<td>Charlie chapas</td>
						<td>char@gmail.com</td>
						<td>6325841251</td>
						<td>Bajo puente</td>
						<td><a href="/user/update/24"><button type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
						</button></a>
						<a href="/user/delete/24"><button type="button" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</button></a>
					</td>
				</tr>
			</tbody>                    
 <#-- <#list users as user>
  <tr>
    <td>${user.firstname}</td> <td>${user.lastname}</td>
  </tr>
  </#list> -->
</table>
</div><#--end container-->
</#macro>

<@display_page/>


