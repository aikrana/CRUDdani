<#macro page_head>
<title>Libros</title>
</#macro>

<#macro css_head>
<link href="/bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/styles.css" rel="stylesheet">
</#macro>

<#macro page_content>
<div>
	<H2>
        FreeMarker
	</H2>
</div>
<div>
	<h1>Basic Page</h1>
	<p>This is the body of the page!</p>
</div>
</#macro>

<#macro page_bootstrap>
<!-- jQuery (necessary for Bootstraps JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
</#macro>


<#macro display_page>
<!DOCTYPE html>
<html>
<head>
	<@page_head/>
	<@css_head/>
</head>
<body>
	<@page_content/>
	<@page_bootstrap/>
		
</body>
</html>
</#macro>
