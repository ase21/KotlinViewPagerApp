package com.trmedia.myapplication.objects

interface Expr {
    class Num(val value: Int) : Expr
    class Sum(val first: Expr, val second: Expr) : Expr
}