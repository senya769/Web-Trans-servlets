<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>web-trans</title>
     <link rel="stylesheet" href="resource/css/style.css">
<jsp:include page="navbar.jsp"/>
</head>
<body>

<section class="py-5 text-center container">
    <div class="row py-lg-5">
        <div class="col-lg-6 col-md-8 mx-auto">
            <h1 class="fw-light">WEB-Trans</h1>
            <p class="lead text-muted">Что-то краткое и ведущее о коллекции ниже - ее содержание, создатель и т.д. Сделайте ее короткой и интересной, но не слишком короткой, чтобы люди просто не пропустили ее полностью.</p>
            <p>
                <a href = "#" type="button" class="btn btn-outline-info">Add cargo</a>
                <button type="button" class="btn btn-outline-info">Find cargo</button>
            </p>
        </div>
    </div>
</section>

<div class="album py-5 bg-light">
    <div class="container">

        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <div class="col">
                <div class="card shadow-sm">
                    <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Эскиз" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Эскиз</text></svg>

                    <div class="card-body">
                        <p class="card-text">Это более широкая карточка с вспомогательным текстом ниже как естественный ввод к дополнительному контенту. Этот контент немного длиннее.</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-outline-secondary">Смотреть</button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">Редактировать</button>
                            </div>
                            <small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadow-sm">
                    <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Эскиз" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Эскиз</text></svg>

                    <div class="card-body">
                        <p class="card-text">Это более широкая карточка с вспомогательным текстом ниже как естественный ввод к дополнительному контенту. Этот контент немного длиннее.</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-outline-secondary">Смотреть</button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">Редактировать</button>
                            </div>
                            <small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card shadow-sm">
                    <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Эскиз" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Эскиз</text></svg>

                    <div class="card-body">
                        <p class="card-text">Это более широкая карточка с вспомогательным текстом ниже как естественный ввод к дополнительному контенту. Этот контент немного длиннее.</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-outline-secondary">Смотреть</button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">Редактировать</button>
                            </div>
                            <small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
