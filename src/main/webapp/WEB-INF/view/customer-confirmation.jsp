<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Confirmation</title>
</head>
<body>
The customer is identified: ${customer.firstName} ${customer.lastName}
<br>
<br>
Free passes: ${customer.freePasses}
<br>
<br>
Postal code: ${customer.postalCode}
<br>
<br>
Course code: ${customer.courseCode}
</body>
</html>