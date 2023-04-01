<!DOCTYPE html>
<html>
<head>
    <title>Catalog Report</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2
        }
    </style>
</head>
<body>
<h1>Catalog Report - ${catalog.name}</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Type</th>
        </tr>
    </thead>
    <tbody>
    <#list catalog.documents as doc>
        <tr>
            <td>${doc.id}</td>
            <td>${doc.title}</td>
            <td>${doc.type}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>
