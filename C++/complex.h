#include<math.h>
class Complex{
public:
    Complex()
    {
        re = 0;
        im = 0;
    }
    Complex(double real, double imag){
        re = real;
        im = imag;                          
    }
    double compAbs(){
        return sqrt(re*re + im*im);
    }
    Complex plus(Complex a){
        double real = re + a.re;
        double imag = im + a.im;
        return Complex(real,imag);
    }
    Complex minus(Complex a){
        double real = re - a.re;
        double imag = im - a.im;
        return Complex(real,imag);
    }
    // return a new Complex object whose value is (this * a)
    Complex times(Complex a) {
        double real = re * a.re - im * a.im;
        double imag = re * a.im + im * a.re;
        return Complex(real, imag);
    }
    // return a new object whose value is (this * alpha)
    Complex times(double alpha) {
        return Complex(alpha * re, alpha * im);
    }
    
    // return a new Complex object whose value is the conjugate of this
    Complex conjugate() {  return Complex(re, -im); }
    // return a new Complex object whose value is the reciprocal of this
    Complex reciprocal() {
        double scale = re*re + im*im;
        return Complex(re / scale, -im / scale);
    }
    // return a / b
    Complex divides(Complex b) {
        return times(b.reciprocal());
    }
    
    // return a new Complex object whose value is the complex exponential of this
    Complex compExp() {
        return Complex(exp(re) * cos(im), exp(re) * sin(im));
    }
    // return a new Complex object whose value is the complex sine of this
    Complex compSin() {
        return Complex(sin(re) * cosh(im), cos(re) * sinh(im));
    }
    // return a new Complex object whose value is the complex cosine of this
    Complex compCos() {
        return Complex(cos(re) * cosh(im), -sin(re) * sinh(im));
    }
    // return a new Complex object whose value is the complex tangent of this
    Complex compTan() {
        return compSin().divides(compCos());
    }
    
    double getReal(){
        return re;
    }
    double getImag(){
        return im;
    }
private:
    double re;  
    double im;
};
