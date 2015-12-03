if NOT "%SA_AMOS_INITIALIZED%" =="" goto done
set CURRDIR=%~dp0%
set PATH=%CURRDIR%..\sa.amos\bin;%PATH%
set CLASSPATH=%CLASSPATH%;%CURRDIR%../sa.amos/bin/javaamos.jar;.;kd.jar
set SA_AMOS_INITIALIZED=1
:done