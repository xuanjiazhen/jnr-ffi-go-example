package cn.zenliu.example.jnr.kt

import jnr.ffi.Struct
import jnr.ffi.annotations.Encoding

/*
Supported Types
All Java primitives are mapped simply to the equivalent C types.

byte - 8 bit signed integer
short - 16 bit signed integer
int - 32 bit signed integer
long - natural long (i.e. 32 bits wide on 32-bit systems, 64 bits wide on 64-bit systems)
float - 32 bit float
double - 64 bit float
The width and/or signed-ness of these basic types can be specified using one of the type alias annotations. e.g.

// Use the correct width for the result from getpid(3)
@pid_t long getpid();

// read(2) returns a signed long result, and its length parameter is an unsigned long
@ssize_t long read(int fd, Pointer data, @size_t long len);
In addition, the following Java types are mapped to a C pointer

String - equivalent to const char *
Pointer - equivalent to void *
Buffer - equivalent to void *

Encodeing()
 */
interface Jnr {
    class GoTime(rt: jnr.ffi.Runtime) : Struct(rt) {
        var wall: Signed64? = null
        var ext: Signed64? = null
        var loc: Pointer? = null
    }

    @Encoding("UTF8")
    fun Time(): String
    fun Time2(): GoTime
}
