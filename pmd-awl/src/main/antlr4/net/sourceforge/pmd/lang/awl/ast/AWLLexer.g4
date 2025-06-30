lexer grammar AWLLexer;

PARSERTOKEN : ';' | ':' | '{' | '}' | '=' | ':=' | '[' | ']' | '(' | ')' | '..' | ',' | '+' | '-' | '.' | '#' | '%' ;

INSTRUCTIONNAME : '<=' | '+AR1' | '+AR2' | '+D' | '-D' | '*D' | '/D' | '==D' | '>D' | '>=D' | '<D' | '<>D' |
  '+I' | '-I' | '*I' | '/I'  | '==I' | '>I' | '>=I' | '<I' | '<>I' | '+R' | '-R' | '*R' | '/R'  | 'RND+' | 'RND-' ;

LOGICCOMPARISON : '==0' | '<>0' | '>0' | '<0' | '>=0' | '<=0' ;

TITLE : 'TITLE' [ \t]* '=' ~[\r\n]* ;

POINTER_OP : 'P#' 'DBX'? ;

ARRAY_INIT : Integer '(' '\'' AnyPrintChar '\'' ')' ;
fragment AnyPrintChar : [\u0040-\u007E] ;

ID : IdentifierStart IdentifierChar* ;
fragment IdentifierStart : '_' | 'a' .. 'z' | 'A' .. 'Z' ;
fragment IdentifierChar : IdentifierStart | Digit | '-' ;

StringConstant : DOUBLE_QUOTED_STRING | SINGLE_QUOTED_STRING ;
fragment DOUBLE_QUOTED_STRING : '"' AnyCharExceptDoubleQuoteNewline* '"' ;
fragment SINGLE_QUOTED_STRING : '\'' AnyCharExceptSingleQuoteNewline* '\'' ;
fragment AnyCharExceptDoubleQuoteNewline : [\u0000-\u0009] | [\u000B] | [\u000C] | [\u000E-\u0021] | [\u0023-\u007F] ;
fragment AnyCharExceptSingleQuoteNewline : [\u0000-\u0009] | [\u000B] | [\u000C] | [\u000E-\u0026] | [\u0028-\u007F]  ;

REAL : Integer '.' Integer ;

INT : Integer ;

fragment Integer : Digit+ ;
fragment Digit : [0-9] ;

HEX_INT : '16#' HexDigit+ ;
fragment HexDigit : [0-9] | [A-F] | [_] ;

BIN_INT : '2#' BinDigit+ ;
BinDigit : [0-1] ;

TIME : 'S5'? ('t' | 'T') '#' Digit+ TimeUnit ;
fragment TimeUnit : 'H' | 'h' | 'M' | 'm' | 'S' | 's' | 'MS' | 'ms' ;

LineComment : '//' ~[\r\n]* -> channel(HIDDEN) ;
BlockComment : '(*' .*? '*)' -> channel(HIDDEN) ;
Whitespace : [ \t]+ -> skip ;
LineTerm : [\r\n]+ -> channel(HIDDEN) ;