#include<iostream>
#include"complex.h"
#define PI 3.1415
using namespace std;
class FFT{
public:
    FFT(){}
    Complex* fft(Complex *x, int len) {
        int N = len;

        // base case
        if (N == 1)
        {
            Complex * comp = new Complex[1];
            *comp = Complex(x[0].getReal(),x[0].getImag());
            return comp;
        }
        
        // radix 2 Cooley-Tukey FFT
        if (N % 2 != 0) { cout<<"N is not a power of 2"; }
        
        // fft of even terms
        Complex* even = new Complex[N/2];
        for (int k = 0; k < N/2; k++) {
            even[k] = x[2*k];
        }
        Complex* q = fft(even,N/2);
        
        // fft of odd terms
        Complex* odd  = even;  // reuse the array
        for (int k = 0; k < N/2; k++) {
            odd[k] = x[2*k + 1];
        }
        Complex* r = fft(odd,N/2);
        
        // combine
        Complex* y = new Complex[N];
        for (int k = 0; k < N/2; k++) {
            double kth = -2 * k * PI / N;
            Complex wk = Complex(cos(kth), sin(kth));
            y[k]       = q[k].plus(wk.times(r[k]));
            y[k + N/2] = q[k].minus(wk.times(r[k]));
        }
        return y;
    }
};
