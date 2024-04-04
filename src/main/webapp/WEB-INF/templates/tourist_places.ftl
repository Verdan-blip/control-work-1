<#import "navbars.ftl" as navbars>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tourist places</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>
<body>

<@navbars.navbars user></@navbars.navbars>

<h1 class="display-1" style="text-align: center; margin-bottom: 48px">Туристические места</h1>

<div class="form-row justify-content-center">
    <div class="input-group mx-auto mb-3" style="width: 25%">
        <input id="search-input" type="search" class="form-control rounded" placeholder="Введите название города"
               aria-label="Search" aria-describedby="search-addon" />
        <button id="search-button" type="button" class="btn btn-outline-primary">Найти места</button>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="image-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="modal-title"></h4>
                <br/>
            </div>
            <div class="modal-body">
                <img id="modal-image" src="" alt="image" width=100% height="75%">
                <h5 class="modal-title" id="modal-location"></h5>
                <p id="modal-text"></p>
            </div>
        </div>
    </div>
</div>

<div id="search-result">
    <div class="container mx-auto mt-4">
        <div id="cards-row" class="row"></div>
    </div>
</div>

<script type="text/javascript" src="resources/js/tourist_places.js"></script>

</body>
</html>