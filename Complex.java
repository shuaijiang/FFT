<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- saved from url=(0061)http://introcs.cs.princeton.edu/java/97data/Complex.java.html -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="icon" href="http://introcs.cs.princeton.edu/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="http://introcs.cs.princeton.edu/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="./Complex_files/java.css" type="text/css">

<title>Complex.java</title>


<meta name="AUTHOR" content="Robert Sedgewick and Kevin Wayne">
<meta name="DESCRIPTION" content="Complex code in Java">
<meta name="TITLE" content="Complex code in Java">
<meta name="KEYWORDS" content="Complex,java,programming,computer science,algorithm,program,code">
<meta name="ROBOTS" content="INDEX,FOLLOW">

</head>


<body youdao="bind">
<center><h1>Complex.java</h1></center><p><br>

Below is the syntax highlighted version of <a href="http://introcs.cs.princeton.edu/java/97data/Complex.java">Complex.java</a>
from <a href="http://introcs.cs.princeton.edu/97data">§9.7 Data Analysis</a>.
</p><p><br>

<!-- Generator: GNU source-highlight 2.5
by Lorenzo Bettini
http://www.lorenzobettini.it
http://www.gnu.org/software/src-highlite -->
</p><pre><tt><span class="comment">/*************************************************************************</span>
<span class="comment"> *  Compilation:  javac Complex.java</span>
<span class="comment"> *  Execution:    java Complex</span>
<span class="comment"> *</span>
<span class="comment"> *  Data type for complex numbers.</span>
<span class="comment"> *</span>
<span class="comment"> *  The data type is "immutable" so once you create and initialize</span>
<span class="comment"> *  a Complex object, you cannot change it. The "final" keyword</span>
<span class="comment"> *  when declaring re and im enforces this rule, making it a</span>
<span class="comment"> *  compile-time error to change the .re or .im fields after</span>
<span class="comment"> *  they've been initialized.</span>
<span class="comment"> *</span>
<span class="comment"> *  % java Complex</span>
<span class="comment"> *  a            = 5.0 + 6.0i</span>
<span class="comment"> *  b            = -3.0 + 4.0i</span>
<span class="comment"> *  Re(a)        = 5.0</span>
<span class="comment"> *  Im(a)        = 6.0</span>
<span class="comment"> *  b + a        = 2.0 + 10.0i</span>
<span class="comment"> *  a - b        = 8.0 + 2.0i</span>
<span class="comment"> *  a * b        = -39.0 + 2.0i</span>
<span class="comment"> *  b * a        = -39.0 + 2.0i</span>
<span class="comment"> *  a / b        = 0.36 - 1.52i</span>
<span class="comment"> *  (a / b) * b  = 5.0 + 6.0i</span>
<span class="comment"> *  conj(a)      = 5.0 - 6.0i</span>
<span class="comment"> *  |a|          = 7.810249675906654</span>
<span class="comment"> *  tan(a)       = -6.685231390246571E-6 + 1.0000103108981198i</span>
<span class="comment"> *</span>
<span class="comment"> *************************************************************************/</span>

<span class="keyword">public</span><span class="normal"> </span><span class="keyword">class</span><span class="normal"> Complex </span><span class="cbracket">{</span>
<span class="normal">    </span><span class="keyword">private</span><span class="normal"> </span><span class="keyword">final</span><span class="normal"> </span><span class="type">double</span><span class="normal"> re</span><span class="symbol">;</span><span class="normal">   </span><span class="comment">// the real part</span>
<span class="normal">    </span><span class="keyword">private</span><span class="normal"> </span><span class="keyword">final</span><span class="normal"> </span><span class="type">double</span><span class="normal"> im</span><span class="symbol">;</span><span class="normal">   </span><span class="comment">// the imaginary part</span>

<span class="normal">    </span><span class="comment">// create a new object with the given real and imaginary parts</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="function">Complex</span><span class="symbol">(</span><span class="type">double</span><span class="normal"> real</span><span class="symbol">,</span><span class="normal"> </span><span class="type">double</span><span class="normal"> imag</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        re </span><span class="symbol">=</span><span class="normal"> real</span><span class="symbol">;</span>
<span class="normal">        im </span><span class="symbol">=</span><span class="normal"> imag</span><span class="symbol">;</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">// return a string representation of the invoking Complex object</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> String </span><span class="function">toString</span><span class="symbol">()</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">im </span><span class="symbol">==</span><span class="normal"> </span><span class="number">0</span><span class="symbol">)</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> re </span><span class="symbol">+</span><span class="normal"> </span><span class="string">""</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">re </span><span class="symbol">==</span><span class="normal"> </span><span class="number">0</span><span class="symbol">)</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> im </span><span class="symbol">+</span><span class="normal"> </span><span class="string">"i"</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">im </span><span class="symbol">&lt;</span><span class="normal">  </span><span class="number">0</span><span class="symbol">)</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> re </span><span class="symbol">+</span><span class="normal"> </span><span class="string">" - "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> </span><span class="symbol">(-</span><span class="normal">im</span><span class="symbol">)</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> </span><span class="string">"i"</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> re </span><span class="symbol">+</span><span class="normal"> </span><span class="string">" + "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> im </span><span class="symbol">+</span><span class="normal"> </span><span class="string">"i"</span><span class="symbol">;</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">// return abs/modulus/magnitude and angle/phase/argument</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="type">double</span><span class="normal"> </span><span class="function">abs</span><span class="symbol">()</span><span class="normal">   </span><span class="cbracket">{</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> Math</span><span class="symbol">.</span><span class="function">hypot</span><span class="symbol">(</span><span class="normal">re</span><span class="symbol">,</span><span class="normal"> im</span><span class="symbol">);</span><span class="normal"> </span><span class="cbracket">}</span><span class="normal">  </span><span class="comment">// Math.sqrt(re*re + im*im)</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="type">double</span><span class="normal"> </span><span class="function">phase</span><span class="symbol">()</span><span class="normal"> </span><span class="cbracket">{</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> Math</span><span class="symbol">.</span><span class="function">atan2</span><span class="symbol">(</span><span class="normal">im</span><span class="symbol">,</span><span class="normal"> re</span><span class="symbol">);</span><span class="normal"> </span><span class="cbracket">}</span><span class="normal">  </span><span class="comment">// between -pi and pi</span>

<span class="normal">    </span><span class="comment">// return a new Complex object whose value is (this + b)</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> Complex </span><span class="function">plus</span><span class="symbol">(</span><span class="normal">Complex b</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        Complex a </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">this</span><span class="symbol">;</span><span class="normal">             </span><span class="comment">// invoking object</span>
<span class="normal">        </span><span class="type">double</span><span class="normal"> real </span><span class="symbol">=</span><span class="normal"> a</span><span class="symbol">.</span><span class="normal">re </span><span class="symbol">+</span><span class="normal"> b</span><span class="symbol">.</span><span class="normal">re</span><span class="symbol">;</span>
<span class="normal">        </span><span class="type">double</span><span class="normal"> imag </span><span class="symbol">=</span><span class="normal"> a</span><span class="symbol">.</span><span class="normal">im </span><span class="symbol">+</span><span class="normal"> b</span><span class="symbol">.</span><span class="normal">im</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">Complex</span><span class="symbol">(</span><span class="normal">real</span><span class="symbol">,</span><span class="normal"> imag</span><span class="symbol">);</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">// return a new Complex object whose value is (this - b)</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> Complex </span><span class="function">minus</span><span class="symbol">(</span><span class="normal">Complex b</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        Complex a </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">this</span><span class="symbol">;</span>
<span class="normal">        </span><span class="type">double</span><span class="normal"> real </span><span class="symbol">=</span><span class="normal"> a</span><span class="symbol">.</span><span class="normal">re </span><span class="symbol">-</span><span class="normal"> b</span><span class="symbol">.</span><span class="normal">re</span><span class="symbol">;</span>
<span class="normal">        </span><span class="type">double</span><span class="normal"> imag </span><span class="symbol">=</span><span class="normal"> a</span><span class="symbol">.</span><span class="normal">im </span><span class="symbol">-</span><span class="normal"> b</span><span class="symbol">.</span><span class="normal">im</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">Complex</span><span class="symbol">(</span><span class="normal">real</span><span class="symbol">,</span><span class="normal"> imag</span><span class="symbol">);</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">// return a new Complex object whose value is (this * b)</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> Complex </span><span class="function">times</span><span class="symbol">(</span><span class="normal">Complex b</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        Complex a </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">this</span><span class="symbol">;</span>
<span class="normal">        </span><span class="type">double</span><span class="normal"> real </span><span class="symbol">=</span><span class="normal"> a</span><span class="symbol">.</span><span class="normal">re </span><span class="symbol">*</span><span class="normal"> b</span><span class="symbol">.</span><span class="normal">re </span><span class="symbol">-</span><span class="normal"> a</span><span class="symbol">.</span><span class="normal">im </span><span class="symbol">*</span><span class="normal"> b</span><span class="symbol">.</span><span class="normal">im</span><span class="symbol">;</span>
<span class="normal">        </span><span class="type">double</span><span class="normal"> imag </span><span class="symbol">=</span><span class="normal"> a</span><span class="symbol">.</span><span class="normal">re </span><span class="symbol">*</span><span class="normal"> b</span><span class="symbol">.</span><span class="normal">im </span><span class="symbol">+</span><span class="normal"> a</span><span class="symbol">.</span><span class="normal">im </span><span class="symbol">*</span><span class="normal"> b</span><span class="symbol">.</span><span class="normal">re</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">Complex</span><span class="symbol">(</span><span class="normal">real</span><span class="symbol">,</span><span class="normal"> imag</span><span class="symbol">);</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">// scalar multiplication</span>
<span class="normal">    </span><span class="comment">// return a new object whose value is (this * alpha)</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> Complex </span><span class="function">times</span><span class="symbol">(</span><span class="type">double</span><span class="normal"> alpha</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">Complex</span><span class="symbol">(</span><span class="normal">alpha </span><span class="symbol">*</span><span class="normal"> re</span><span class="symbol">,</span><span class="normal"> alpha </span><span class="symbol">*</span><span class="normal"> im</span><span class="symbol">);</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">// return a new Complex object whose value is the conjugate of this</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> Complex </span><span class="function">conjugate</span><span class="symbol">()</span><span class="normal"> </span><span class="cbracket">{</span><span class="normal">  </span><span class="keyword">return</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">Complex</span><span class="symbol">(</span><span class="normal">re</span><span class="symbol">,</span><span class="normal"> </span><span class="symbol">-</span><span class="normal">im</span><span class="symbol">);</span><span class="normal"> </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">// return a new Complex object whose value is the reciprocal of this</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> Complex </span><span class="function">reciprocal</span><span class="symbol">()</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="type">double</span><span class="normal"> scale </span><span class="symbol">=</span><span class="normal"> re</span><span class="symbol">*</span><span class="normal">re </span><span class="symbol">+</span><span class="normal"> im</span><span class="symbol">*</span><span class="normal">im</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">Complex</span><span class="symbol">(</span><span class="normal">re </span><span class="symbol">/</span><span class="normal"> scale</span><span class="symbol">,</span><span class="normal"> </span><span class="symbol">-</span><span class="normal">im </span><span class="symbol">/</span><span class="normal"> scale</span><span class="symbol">);</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">// return the real or imaginary part</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="type">double</span><span class="normal"> </span><span class="function">re</span><span class="symbol">()</span><span class="normal"> </span><span class="cbracket">{</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> re</span><span class="symbol">;</span><span class="normal"> </span><span class="cbracket">}</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="type">double</span><span class="normal"> </span><span class="function">im</span><span class="symbol">()</span><span class="normal"> </span><span class="cbracket">{</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> im</span><span class="symbol">;</span><span class="normal"> </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">// return a / b</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> Complex </span><span class="function">divides</span><span class="symbol">(</span><span class="normal">Complex b</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        Complex a </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">this</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> a</span><span class="symbol">.</span><span class="function">times</span><span class="symbol">(</span><span class="normal">b</span><span class="symbol">.</span><span class="function">reciprocal</span><span class="symbol">());</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">// return a new Complex object whose value is the complex exponential of this</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> Complex </span><span class="function">exp</span><span class="symbol">()</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">Complex</span><span class="symbol">(</span><span class="normal">Math</span><span class="symbol">.</span><span class="function">exp</span><span class="symbol">(</span><span class="normal">re</span><span class="symbol">)</span><span class="normal"> </span><span class="symbol">*</span><span class="normal"> Math</span><span class="symbol">.</span><span class="function">cos</span><span class="symbol">(</span><span class="normal">im</span><span class="symbol">),</span><span class="normal"> Math</span><span class="symbol">.</span><span class="function">exp</span><span class="symbol">(</span><span class="normal">re</span><span class="symbol">)</span><span class="normal"> </span><span class="symbol">*</span><span class="normal"> Math</span><span class="symbol">.</span><span class="function">sin</span><span class="symbol">(</span><span class="normal">im</span><span class="symbol">));</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">// return a new Complex object whose value is the complex sine of this</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> Complex </span><span class="function">sin</span><span class="symbol">()</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">Complex</span><span class="symbol">(</span><span class="normal">Math</span><span class="symbol">.</span><span class="function">sin</span><span class="symbol">(</span><span class="normal">re</span><span class="symbol">)</span><span class="normal"> </span><span class="symbol">*</span><span class="normal"> Math</span><span class="symbol">.</span><span class="function">cosh</span><span class="symbol">(</span><span class="normal">im</span><span class="symbol">),</span><span class="normal"> Math</span><span class="symbol">.</span><span class="function">cos</span><span class="symbol">(</span><span class="normal">re</span><span class="symbol">)</span><span class="normal"> </span><span class="symbol">*</span><span class="normal"> Math</span><span class="symbol">.</span><span class="function">sinh</span><span class="symbol">(</span><span class="normal">im</span><span class="symbol">));</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">// return a new Complex object whose value is the complex cosine of this</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> Complex </span><span class="function">cos</span><span class="symbol">()</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">Complex</span><span class="symbol">(</span><span class="normal">Math</span><span class="symbol">.</span><span class="function">cos</span><span class="symbol">(</span><span class="normal">re</span><span class="symbol">)</span><span class="normal"> </span><span class="symbol">*</span><span class="normal"> Math</span><span class="symbol">.</span><span class="function">cosh</span><span class="symbol">(</span><span class="normal">im</span><span class="symbol">),</span><span class="normal"> </span><span class="symbol">-</span><span class="normal">Math</span><span class="symbol">.</span><span class="function">sin</span><span class="symbol">(</span><span class="normal">re</span><span class="symbol">)</span><span class="normal"> </span><span class="symbol">*</span><span class="normal"> Math</span><span class="symbol">.</span><span class="function">sinh</span><span class="symbol">(</span><span class="normal">im</span><span class="symbol">));</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">// return a new Complex object whose value is the complex tangent of this</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> Complex </span><span class="function">tan</span><span class="symbol">()</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> </span><span class="function">sin</span><span class="symbol">().</span><span class="function">divides</span><span class="symbol">(</span><span class="function">cos</span><span class="symbol">());</span>
<span class="normal">    </span><span class="cbracket">}</span>
<span class="normal">    </span>


<span class="normal">    </span><span class="comment">// a static version of plus</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="keyword">static</span><span class="normal"> Complex </span><span class="function">plus</span><span class="symbol">(</span><span class="normal">Complex a</span><span class="symbol">,</span><span class="normal"> Complex b</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="type">double</span><span class="normal"> real </span><span class="symbol">=</span><span class="normal"> a</span><span class="symbol">.</span><span class="normal">re </span><span class="symbol">+</span><span class="normal"> b</span><span class="symbol">.</span><span class="normal">re</span><span class="symbol">;</span>
<span class="normal">        </span><span class="type">double</span><span class="normal"> imag </span><span class="symbol">=</span><span class="normal"> a</span><span class="symbol">.</span><span class="normal">im </span><span class="symbol">+</span><span class="normal"> b</span><span class="symbol">.</span><span class="normal">im</span><span class="symbol">;</span>
<span class="normal">        Complex sum </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">Complex</span><span class="symbol">(</span><span class="normal">real</span><span class="symbol">,</span><span class="normal"> imag</span><span class="symbol">);</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> sum</span><span class="symbol">;</span>
<span class="normal">    </span><span class="cbracket">}</span>



<span class="normal">    </span><span class="comment">// sample client for testing</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="keyword">static</span><span class="normal"> </span><span class="type">void</span><span class="normal"> </span><span class="function">main</span><span class="symbol">(</span><span class="normal">String</span><span class="symbol">[]</span><span class="normal"> args</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        Complex a </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">Complex</span><span class="symbol">(</span><span class="number">5.0</span><span class="symbol">,</span><span class="normal"> </span><span class="number">6.0</span><span class="symbol">);</span>
<span class="normal">        Complex b </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">Complex</span><span class="symbol">(-</span><span class="number">3.0</span><span class="symbol">,</span><span class="normal"> </span><span class="number">4.0</span><span class="symbol">);</span>

<span class="normal">        System</span><span class="symbol">.</span><span class="normal">out</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="string">"a            = "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> a</span><span class="symbol">);</span>
<span class="normal">        System</span><span class="symbol">.</span><span class="normal">out</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="string">"b            = "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> b</span><span class="symbol">);</span>
<span class="normal">        System</span><span class="symbol">.</span><span class="normal">out</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="string">"Re(a)        = "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> a</span><span class="symbol">.</span><span class="function">re</span><span class="symbol">());</span>
<span class="normal">        System</span><span class="symbol">.</span><span class="normal">out</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="string">"Im(a)        = "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> a</span><span class="symbol">.</span><span class="function">im</span><span class="symbol">());</span>
<span class="normal">        System</span><span class="symbol">.</span><span class="normal">out</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="string">"b + a        = "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> b</span><span class="symbol">.</span><span class="function">plus</span><span class="symbol">(</span><span class="normal">a</span><span class="symbol">));</span>
<span class="normal">        System</span><span class="symbol">.</span><span class="normal">out</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="string">"a - b        = "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> a</span><span class="symbol">.</span><span class="function">minus</span><span class="symbol">(</span><span class="normal">b</span><span class="symbol">));</span>
<span class="normal">        System</span><span class="symbol">.</span><span class="normal">out</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="string">"a * b        = "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> a</span><span class="symbol">.</span><span class="function">times</span><span class="symbol">(</span><span class="normal">b</span><span class="symbol">));</span>
<span class="normal">        System</span><span class="symbol">.</span><span class="normal">out</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="string">"b * a        = "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> b</span><span class="symbol">.</span><span class="function">times</span><span class="symbol">(</span><span class="normal">a</span><span class="symbol">));</span>
<span class="normal">        System</span><span class="symbol">.</span><span class="normal">out</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="string">"a / b        = "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> a</span><span class="symbol">.</span><span class="function">divides</span><span class="symbol">(</span><span class="normal">b</span><span class="symbol">));</span>
<span class="normal">        System</span><span class="symbol">.</span><span class="normal">out</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="string">"(a / b) * b  = "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> a</span><span class="symbol">.</span><span class="function">divides</span><span class="symbol">(</span><span class="normal">b</span><span class="symbol">).</span><span class="function">times</span><span class="symbol">(</span><span class="normal">b</span><span class="symbol">));</span>
<span class="normal">        System</span><span class="symbol">.</span><span class="normal">out</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="string">"conj(a)      = "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> a</span><span class="symbol">.</span><span class="function">conjugate</span><span class="symbol">());</span>
<span class="normal">        System</span><span class="symbol">.</span><span class="normal">out</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="string">"|a|          = "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> a</span><span class="symbol">.</span><span class="function">abs</span><span class="symbol">());</span>
<span class="normal">        System</span><span class="symbol">.</span><span class="normal">out</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="string">"tan(a)       = "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> a</span><span class="symbol">.</span><span class="function">tan</span><span class="symbol">());</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="cbracket">}</span>
</tt></pre>

<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script><script src="./Complex_files/ga.js" type="text/javascript"></script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-10811519-1");
pageTracker._trackPageview();
} catch(err) {}</script>



<p><br></p><address><small>
Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne.
<br>Last updated: Wed Feb  9 09:20:16 EST 2011.
</small></address>


</body><div></div></html>