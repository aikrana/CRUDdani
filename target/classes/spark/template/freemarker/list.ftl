	

<#include "base.ftl">

<#macro page_content>
<div class="container">
	<div class="jumbotron">
		<h1>Libros</h1>
	</div>
	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav">
				<li>
					<a href="/"><button type="button" class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
					</button></a>
				</li>
				
				<li>
					<a href="/user/create"><button type="button" class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					</button></a>
				</li>
				
			</ul>
		</div>
	</div>

	<div class=tabla><table width="600" cellpadding="5" class="table table-bordered table-striped">
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
			<#if libros??>
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
  			</#if>
		</tbody>                    
 	</table></div>

	<#if pages??>
	 	<nav>
		  <ul class="pagination">
		  	<#if (page == 1)>
			    <li class="disabled">
			      <span>
			        <span aria-hidden="true">&laquo;</span>
			      </span>
			    </li>
		    <#else>
				<li>
			      <a href="/p/1" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			</#if>

		    <#list 1..pages as i>
				<#if (page == i)>
  					<li class="active"><span>${i}</span></li>
  				<#else>
  					<li><a href="/p/${i}">${i}</a></li>
  				</#if>
			</#list>
			<#if (page == pages)>
			    <li class="disabled">
			      <span>
			        <span aria-hidden="true">&raquo;</span>
			      </span>
			    </li>
		    <#else>
				<li>
			      <a href="/p/${pages}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			</#if>
		  </ul>
		</nav>
	</#if>
</div><#--end container-->
</#macro>

<@display_page/>


