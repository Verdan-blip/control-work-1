<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <link rel="stylesheet" href="resources/css/form.css" type="text/css">
</head>
<body>
    <div class="container-background">
        <div class="container">
            <span class="container-title">Войдите в свой аккаунт</span>
            <form method="post" action="login/progress">
                <span id="container-log" class="container-log"></span>
                <input id="email" class="container-input" type="email" name="email" placeholder="Почта" required>
                <input id="password" class="container-input" type="password" name="password" placeholder="Пароль" required>
                <div class="container-text">
                    <label for="remember-me">Запомнить меня</label>
                    <input id="remember-me" class="container-checkbox" name="remember-me" type="checkbox" value="true">
                </div>
                <button class="container-submit" type="submit" id="submit-button">Войти</button>
            </form>
        </div>
    </div>



</body>
</html>