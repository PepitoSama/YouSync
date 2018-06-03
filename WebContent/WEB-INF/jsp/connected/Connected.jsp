<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.connected.css"></link>
    <script type="text/javascript" src="js/MySimpleScripts.js"></script>
    <title>YouSync - ${connectedUser.getLogin() }</title>
</head>
<body>
    <div class="top-content" style="position: relative; z-index: 0; ">
        <!-- Top menu -->
        <nav role="navigation" class="navbar navbar-inverse navbar-no-bg">
            <div class="container">
                <div class="navbar-header">
                    <button data-target="#top-navbar-1" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="connected" class="navbar-brand"><i class="fa fa-cloud-download"></i></a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div id="top-navbar-1" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="topDownload" class="scroll-link"><i class="fa fa-line-chart"></i> Top Download</a></li>
                     <li><a href="admin" class="scroll-link" id="hiddenAdmin"><i class="fa fa-tachometer"></i> Admin</a></li>
                        <li><a href="logout" class="scroll-link" name = "logout"><i class="fa fa-sign-out"></i> Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <div class="inner-bg">
            <div class="container">
                <div class="row">
                    <div class="col-sm-5 phone wow fadeInLeft animated text-center" style="visibility: visible; animation-name: fadeInLeft;">
                        <img class="img-responsive youSyncLogo" alt="youSyncLogo" src="img/logo/LogoWithBlur.png">
                    </div>
                    
                    <div class="col-sm-7 text wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">
                        <form method="post" action="connected">
                            <input id='txtUrlPlaylist' name='txtUrlPlaylist' type='text' value='${txtUrlPlaylist}'  class="form-control" placeholder="Add a playlist"/>
                            <br />
                            <button type="submit" class="btnAddPlaylist btn btn-primary"><i class="fa fa-plus-circle"></i> </button>
                            
                            <br/>
                        </form>
                    </div>
                </div>
                
                <div class="playlists">
                    <table class="table table-dark">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <td>Url</td>
                                <td>Last Sync</td>
                                <td>Download</td>
                                <td>Sync</td>
                                <td>Remove</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="playlist" items="${playlistList}">
                                <tr>
                                    <th scope="row"><c:out value="${playlist.getIdPlaylist()}"/></th>
                                    <td><c:out value="${playlist.getUrl()}"/></td>
                                    <td><c:out value="${playlist.getLastSync()}"/></td>
                                    <td><button type="submit" class="btnDownloadPlaylist btn"><i class="fa fa-cloud-download"></i></button></td>
                                    <form action="download" method="get">
                                        <td><button type="submit" class="btnSyncPlaylist btn"><i class="fa fa-refresh"></i></button></td>
                                    </form>
                                    
                                    <td><button type="submit" class="btnRemPlaylist btn btn-outline-dark"><i class="fa fa-minus-circle" style="color:red"></i></button></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>      
    </div>
        
    <footer class="text-center bck_gray">
        <div class="footer-below">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <ul class="social_icon_list">
                            <li><a class="fb_icon" target="_blank" href="https://www.zewo.at/bilder/projects/not-available-yet.jpg"><i class="fa fa-facebook"></i></a></li>
                            <li><a class="twit_icon" target="_blank" href="https://www.zewo.at/bilder/projects/not-available-yet.jpg"><i class="fa fa-twitter"></i></a></li>
                            <li><a target="_blank" href="https://www.zewo.at/bilder/projects/not-available-yet.jpg"class="gogle_plus_icon"><i class="fa fa-google-plus"></i></a></li>
                            <li><a target="_blank" href="https://www.zewo.at/bilder/projects/not-available-yet.jpg" class="vimeo_icon"><i class="fa fa-instagram"></i></a></li>
                            
                        </ul>
                    </div>
                    <div class="col-lg-12 mar_bot_top_ten">
                            <p>
                                <br />
                                Powered by 
                                 <a href="https://rg3.github.io/youtube-dl/" title="youtube-dl" target="_blank">
                                    youtube-dl
                                </a>
                                <br />
                                <i class="fa fa-bullseye"></i> 2016. Design by
                                <a href="https://web.facebook.com/iamgurdeeposahan" title="gurdeeposahan" target="_blank">
                                    Iamgurdeeposahan
                                </a>
                            </p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>

