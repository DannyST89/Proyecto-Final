<%-- 
    Document   : indexx
    Created on : 11/05/2022, 01:44:10 PM
    Author     : DSdev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>EasyMarket</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
              rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
                crossorigin="anonymous"></script>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/> 
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <header>
            <!-- llamamos al componente navbar -->
            <jsp:include page="FrmNavBar.jsp"/>
        </header>
    <div class="container ">
      <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
        <div class="carousel-indicators" >
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
          </div>
          <div class="carousel-inner">
            <div class="carousel-item active" data-bs-interval="5000">
              <img src="images/img1.jpg" class="d-block w-100" alt="...">
              <div class="carousel-caption d-none d-md-block"style="background-color: #212A32;">
                <h5 class="text-white">Producto Frescos Siempre</h5>
                <p class="text-white">Productos seleccionados de la más alta calidad.</p>
                <button class="btn text-white" style="background-color: #008788;">Contactenos</button>
              </div>
            </div>
            <div class="carousel-item" data-bs-interval="5000">
              <img src="images/img2.jpg" class="d-block w-100" alt="...">
              <div class="carousel-caption d-none d-md-block" style="background-color: #212A32;">
                <h5 class="text-white">Venga y compara la calidad de nuestros productos</h5>
                <p class="text-white">Desde el primer rayo de sol, nuestra misión es brindarle los más altos estandares de calidad.</p>
                <button class="btn text-white" style="background-color: #008788;">Contactenos</button>
              </div>
            </div>
            <div class="carousel-item"data-bs-interval="5000">
              <img src="images/img3.jpg" class="d-block w-100" alt="...">
              <div class="carousel-caption d-none d-md-block"style="background-color: #212A32;">
                  <h5 class="text-white">Ofertas Siempre</h5>
                  <button class="btn text-white"style="background-color: #008788;">Contactenos</button>
              </div>
            </div>
               <div class="carousel-item"data-bs-interval="5000">
              <img src="images/img4.jpg" class="d-block w-100" alt="...">
              <div class="carousel-caption d-none d-md-block"style="background-color: #212A32;">
                <h5 class="text-white">Personal capacitado</h5>
                <p class="text-white">Cada uno de nuestros colaboradores, estan listros para facilitarle su compra y hacerlo sentir como en casa.</p>
                <button class="btn text-white" style="background-color: #008788;">Contactenos</button>
              </div>
            </div>
          </div>
          <button class="carousel-control-prev " type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
      </div>
       
    </div>
        <!-- llamamos al componente Footer -->
            <jsp:include page="FrmFooter.jsp"/>
    
    <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>

    </body>
</html>
