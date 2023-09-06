#include <iostream>
#include <fstream>
#include <cmath>

using namespace std;

int main() {
    double bok, przekatna;
    ofstream plik_wy("wynik2.txt");

    for (int i = 1; i <= 3; i++) {
        cout << "Podaj dlugosc boku kwadratu " << i << ": ";
        cin >> bok;

        przekatna = bok * sqrt(2);

        cout << "Przekatna kwadratu " << i << " wynosi " << przekatna << endl;

        plik_wy << "Przekatna kwadratu " << i << " wynosi " << przekatna << endl;
    }

    plik_wy.close();

    return 0;
}
