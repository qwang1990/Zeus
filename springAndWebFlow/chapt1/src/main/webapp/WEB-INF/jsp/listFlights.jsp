<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List Flights</title>
</head>
<body>
<h1>List Flights</h1>
<p>
You searched for flights leaving ${searchFlights.departFrom} on or about
${searchFlights.departOn}, heading to ${searchFlights.arriveAt}, returning on
or about ${searchFlights.returnOn}.
</p>
<table>
  <thead>
    <tr>
      <th>Number of Legs</th>
      <th>Total Travel Time</th>
      <th>Total Cost</th>
       </tr>
        </thead>
        <tbody>
        <c:forEach items="${flights}" var="flight">
        <tr>
          <td>${flight.numberOfLegs}</td>
          <td>${flight.totalTravelTime}</td>
          <td>$${flight.totalCost}</td>
        </tr>
        </c:forEach>
        </tbody>
      </table>
      </body>
      </html>
