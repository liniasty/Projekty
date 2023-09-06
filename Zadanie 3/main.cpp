#include <iostream>
#include <fstream>

using namespace std;

int main() {
    ofstream plik_wy("wynik3.txt");

    for (int i = 1000; i <= 2000; i++) {
        int suma = 0;
        int liczba = i;

        while (liczba > 0) {
            suma += liczba % 10;
            liczba /= 10;
        }

        if (suma == 6) {
            cout << i << endl;
            plik_wy << i << endl;
        }
    }

    plik_wy.close();

    return 0;
}
