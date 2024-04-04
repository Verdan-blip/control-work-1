<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <link rel="stylesheet" href="resources/css/form.css" type="text/css" />
</head>
<body>
  <div class="container-background">
    <div class="container">
      <span class="container-title">Регистрация</span>
      <form>
        <input id="name" class="container-input" name="name" type="text" placeholder="Имя" required>
        <input id="lastname" class="container-input" name="lastname" type="text" placeholder="Фамилия" required>
        <select id="gender" class="container-input" name="gender">
          <option name="gender" value="m">Мужской</option>
          <option name="gender" value="f">Женский</option>
        </select>
        <input id="phone" class="container-input" type="tel" name="phone" placeholder="Номер телефона" maxlength="12" required>
        <span id="container-log-phone" class="container-log"></span>
        <input id="email" class="container-input" type="email" name="email" placeholder="Почта" required>
        <span id="container-log-email" class="container-log"></span>
        <input id="password" class="container-input" type="password" name="password" placeholder="Пароль" required>
        <button id="register-button" class="container-submit" type="button">Зарегистрироваться</button>
      </form>
    </div>
  </div>

  <script src="resources/js/registration.js" type="text/javascript"></script>

</body>
</html>