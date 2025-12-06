<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Saved</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card border-0 shadow">
                    <div class="card-body text-center p-5">
                        <div class="alert alert-success mb-4" role="alert">
                            <i class="bi bi-check-circle-fill fs-1"></i>
                            <h4 class="alert-heading mt-3">Success!</h4>
                            <p class="mb-0">Contact with ID ${id} inserted successfully</p>
                        </div>
                        
                        <a href="all" class="btn btn-primary btn-lg">
                            <i class="bi bi-list-ul"></i> View All Contacts
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
