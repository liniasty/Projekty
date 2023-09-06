<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="strona2.css">
    <title>Document</title>
</head>
<body>
<div id="gora">
<img id="photo" src="KB.png" alt="">
<a href="index.php">Wyświetl tabele</a>

<a href="storona1.php" style="margin-left: 250px">Podaj własnego sportowca</a>
</div>

        
    <div id="main">
    <div id="tabela">
        <p> Średnia ilość zwycięstw w bazie to
    <?php
    require_once('connect.php');
    $polaczenie = mysqli_connect($host,$user,$pass,$db);
    $kwer = "Select round(avg(wygrane)) from sportowcy;";
    $rezultat = mysqli_query($polaczenie,$kwer);
    $wiersz = mysqli_fetch_array($rezultat);
    echo $wiersz[0];
    mysqli_close($polaczenie); 
    ?>
    zwycięstw </p>
    </div>
</div>
<div id="stopka" style="text-align:center">
Kordian Błaszczyk 2D gr2
</div>
</body>
</html>