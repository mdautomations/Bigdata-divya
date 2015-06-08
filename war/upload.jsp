<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%@page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload your CSV file here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h3>Upload the CSV file</h3>
<% BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService(); %>
 <form action="<%= blobstoreService.createUploadUrl("/upload") %>" method="post" enctype="multipart/form-data">
        <input type="file" name="data">
        <input type="submit" value="Submit">
    </form>
    
    
</body>
</html>