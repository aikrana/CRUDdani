	

<#include "base.ftl">


<#macro page_content>
<div class="container">
 
            <div class="jumbotron">
                <h1>${jumbotron}</h1>
            </div>
 
            <div class="navbar">
    <div class="navbar-inner">
        <ul class="nav">
 
            <li ><a href="/"><i class="icon-th icon-black"></i> Listar</a></li>
            <li class="active"><a href="/user/create"><i class="icon-plus-sign icon-black"></i> Crear</a></li>
 
                    </ul>
    </div>

<fieldset>

  <form name="user" action="${action}" method="post" class="form-horizontal">
        <div class="input-prepend">
        	T&iacute;tulo: <input type="text" name="titulo" value="${titulo}" class="input-xlarge"/><br/><br/>
        </div>
        <div class="input-prepend">
    		Autor: <input type="text" name="autor" value="${autor}" class="input-xlarge"/><br/><br/>
    	</div>
    	<div class="input-prepend">
    		Editorial: <input type="text" name="editorial" value="${editorial}" class="input-xlarge"/><br/><br/>
    	</div>
    	<div class="input-prepend">
    		ISBN: <input type="text" name="isbn" value="${isbn}" class="input-xlarge"/><br/><br/>
    	</div>
    <input type="submit" value="  Guardar  " class="btn btn-primary"/>
  </form>
</fieldset>
<br/>

</#macro>

<@display_page/>


