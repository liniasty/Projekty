<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="index.css">
    <title>Document</title>
</head>
<body>

<div id="gora">
<img id="photo" src="KB.png" alt="">
<a href="storona1.php">Podaj własnego sportowca</a>

<a href="strona2.php" style="margin-left: 250px">Ciekawostka</a>
</div>

        
    <div id="main">
    <div id="tabela">
    <?php
    if(isset($_POST['litera'])){
        echo <<<END
        <table>
            <tr>
                <th>Imie</th>
                <th>Nazwisko</th>
                <th>Sport</th>
                <th>Typ Sportu</th>
            </tr>
        END;
        require_once('connect.php');
        $polaczenie=mysqli_connect($host,$user,$pass,$db) or die("Błąd połączenia z bazą danych");
        $litera = mysqli_real_escape_string($polaczenie, $_POST['litera']);
        $wygrane = mysqli_real_escape_string($polaczenie, $_POST['liczba']);
        $kwer = "SELECT imie, nazwisko, Sport, typ from sportowcy Join typysportu on typSportu = idSportu WHERE 
         ORDER BY wygrane;";
        $rezultat=mysqli_query($polaczenie,$kwer) or die("Błąd zapytania do bazy danych");
        
        while($row=mysqli_fetch_row($rezultat)){
            echo '<tr> <td>', $row[0], '</td> <td>', $row[1], '</td> <td>', $row[2], '</td> <td>', $row[3], '</td> </tr>';
        }
        echo '</table>';
        mysqli_close($polaczenie);
    }
    else {
        echo "Formularz nie został wypełniony.";
    }
    ?>


<form method="post" action="">
    <label for='litera'>Podaj typ A, B lub C</label>
    <input type='text' id='litera' name="litera" required></input> <br>
    <label for="liczba">Podaj maksymalną liczbę zwycięstw</label>
    <input type="number" id='liczba' name='liczba' required></input> <br>
    <input type="submit">
</form>
</div>
</div>
<div id="stopka" style="text-align:center">
Kordian Błaszczyk 2D gr2
</div>
</body>
</html>
