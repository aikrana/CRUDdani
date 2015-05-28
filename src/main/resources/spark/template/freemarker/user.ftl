	

<#include "base.ftl">


<#macro page_content>
<div class="container">
 
            <div class="jumbotron">
                <h1>${jumbotron}</h1>
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

<fieldset>
  <form name="user" action="${action}" method="post" class="form-horizontal">
    <table>
      <tr>
        <div class="input-prepend">
          <td><b>T&iacute;tulo</b></td>
          <td><input type="text" name="titulo" value="${titulo}" class="input-xlarge"/><br><br></td>
        </div>
      </tr>
      <tr>
        <div class="input-prepend">
          <td><b>Autor</b></td>
          <td><input type="text" name="autor" value="${autor}" class="input-xlarge"/><br><br></td>
        </div>
      </tr>
      <tr>
        <div class="input-prepend">
          <td><b>Editorial</b>&nbsp&nbsp&nbsp</td>
          <td><input type="text" name="editorial" value="${editorial}" class="input-xlarge"/><br><br></td>
        </div>
      </tr>
      <tr>
        <div class="input-prepend">
          <td><b>ISBN<b></td>
          <td><input type="text" name="isbn" value="${isbn}" class="input-xlarge"/></td>
        </div>
      </tr>
    </table>
    <br>    
    <input type="submit" value="  Guardar  " class="btn btn-primary"/>
    <#if p??><input type="hidden" name="p" value="${p}"></#if><#--source page number for redirection-->
    
  </form>
</fieldset>
<br/>

</#macro>

<@display_page/>


