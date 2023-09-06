#include <iostream>
#include <fstream>
using namespace std;

int main() {
    ifstream plik_we("dane.txt");
    ofstream plik_wy("wynik.txt");

    if (plik_we.is_open() && plik_wy.is_open()) {
        int a, b, suma, roznica;
        while (plik_we >> a >> b) {
            suma = a + b;
            roznica = a - b;
            plik_wy <<suma<<" - "<<roznica<< endl;
        }

        plik_we.close();
        plik_wy.close();
        cout << "Wynik zosta� zapisany do pliku 'wynik.txt'." << endl;
    } else {
        cout << "Nie uda�o si� otworzy� pliku." << endl;
    }

    return 0;
}
