<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Search For Flights</title>
</head>
<body>
<h1>Search for Flights</h1>
<spring:nestedPath path="searchFlights">
<form action="" method="post">
<table>
<tr>
  <td>Depart From:</td>
  <td>
<spring:bind path="departFrom">
<input type="text" name="${status.expression}" value="${status.value}" />
    </spring:bind>
  </td>
  <td>Depart On:</td>
  <td>
<spring:bind path="departOn">
<input type="text" name="${status.expression}" value="${status.value}" />
    </spring:bind>
    <span style="font-size:smaller">(yyyy-MM-dd HH)</span>
  </td>
</tr>
<tr>
  <td>Arrive At:</td>
  <td>
<spring:bind path="arriveAt">
<input type="text" name="${status.expression}" value="${status.value}" />
    </spring:bind>
  </td>
  <td>Return On:</td>
  <td>
  <spring:bind path="returnOn">
  <input type="text" name="${status.expression}" value="${status.value}" />
      </spring:bind>
      <span style="font-size:smaller">(yyyy-MM-dd HH)</span>
    </td>
  </tr>
  <tr>
  <td />
    <td><input type="submit" value="Search" /></td>
    <td />
    <td />
  </tr>
  </table>
  </form> </spring:nestedPath>
  </body>
  </html>