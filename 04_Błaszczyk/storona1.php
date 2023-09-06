<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="storona1.css">
    <title>Document</title>
</head>
<body>
<div id="gora">
<img id="photo" src="KB.png" alt="">
<a href="index.php">Wyświetl tabele</a>

<a href="strona2.php" style="margin-left: 250px">Ciekawostka</a>
</div>
<div id="main">
    <div id="tabela">
    <form action="" method="post">
        <label for="imie">Podaj imię</label><input type="text" id="imie" name="imie"> <br>
        <label for="nazwisko">Podaj nazwisko</label><input type="text" id="nazwisko" name="nazwisko"> <br>
        <label for="typSportu">Podaj typ sportu A, B lub C</label><input type="text" id="typSportu" name="typSportu"> <br>
        <label for="Sport">Podaj nazwe sportu</label><input type="text" id="Sport" name="Sport"> <br>
        <label for="wygrane">Podaj ilość wygranych</label><input id="wygrane" name="wygrane" type="number"> <br>
        <input type="submit"> <br>
    <?php
    if(isset($_POST['imie'])){
     require_once('connect.php');
            $polaczenie = mysqli_connect($host, $user, $pass, $db);
        $imie = mysqli_real_escape_string($polaczenie, $_POST['imie']);
        $nazwisko = mysqli_real_escape_string($polaczenie, $_POST['nazwisko']);
        $typSportu = mysqli_real_escape_string($polaczenie, $_POST['typSportu']);
        $Sport = mysqli_real_escape_string($polaczenie, $_POST['Sport']);
        $wygrane = intval($_POST['wygrane']);   
    settype($wygrane,'integer');
    if(is_string($imie) && is_string($nazwisko) && is_string($Sport) && is_int($wygrane) && $wygrane>=0) {
        if($typSportu == "A" || $typSportu == "B" || $typSportu == "C") {
            
            $stmt = mysqli_stmt_init($polaczenie);
            $kwer = "INSERT INTO `sportowcy`(`imie`, `nazwisko`, `typSportu`, `Sport`,`wygrane`) VALUES (?, ?, ?, ?, ?)";

            if(mysqli_stmt_prepare($stmt, $kwer)) {
                mysqli_stmt_bind_param($stmt, "ssssi", $imie, $nazwisko, $typSportu, $Sport, $wygrane);
                mysqli_stmt_execute($stmt);

                if(mysqli_affected_rows($polaczenie) == 1) {
                    echo "<p>Rekord dodany do bazy danych.</p>";
                } else {
                    echo "<p>Błąd zapytania do bazy danych.</p>";
                }
            } else {
                echo "<p>Błąd zapytania do bazy danych.</p>";
            }
        } else {
            echo "<p>Zły typ sportu.</p>";
        }
    } else {
        echo "<p>Złe dane.</p>";
    }
    mysqli_close($polaczenie);
    }
    
    ?>
    </form>
    </div>
</div>
<div id="stopka" style="text-align:center">
Kordian Błaszczyk 2D gr2
</div>
</body>
</html>
<?php

?>