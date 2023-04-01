<html>
<head>
    <title>Catalog Report</title>
</head>
<body>
    <h1>${catalog.getName()} Report</h1>

    <h2>Documents:</h2>
    <ul>
    <#list catalog.getDocuments() as document>
        <li>${document.getTitle()} (${document.getType()})</li>
    </#list>
    </ul>
</body>
</html>
