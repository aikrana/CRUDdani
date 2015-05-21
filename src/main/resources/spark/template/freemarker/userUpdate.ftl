	

<#include "base.ftl">

<#macro page_head>
<title>ViralPatel.net - FreeMarker Hello World</title>
<link rel="stylesheet" href="/css/styles.css">
</#macro>

<#macro page_content>
<fieldset>
  <legend>Update User</legend>
  <form name="user" action="/user/update/${id}" method="post">
    Firstname: <input type="text" name="firstname" value="${user.firstname}"/>       <br/>
    Lastname: <input type="text" name="lastname" value="${user.lastname}"/> <br/>
    <input type="submit" value="   Save   " />
  </form>
</fieldset>
<br/>

</#macro>

<@display_page/>


