# HTTP-Downloader
Mixed mode (GUI + Console) MultiThread downloader.

Console mode is finished, some GUI Features are under development.
```
Usage:
         -n set threads count
         -l set download speed, default value 1073741824 used if not specified
         -f set download list file path:
           file structure (line separator is "/r/n", empty lines ignored, line after "#" is commented):
           ================================================FileBegin===============================================================
           #http://i1.wp.com/www.thomasmaurer.ch/wp-content/uploads/2013/08/Configure-SMB-Bandwidth-Limit-via-PowerShell.png
           http://68.media.tumblr.com/8bc372508a83e41de744f52d2d55f180/tumblr_o4k8i3y60i1qhdsvko1_1280.jpg
           https://theconservativetreehouse.files.wordpress.com/2014/12/java-sea.jpg
           https://assets-cdn.github.com/images/modules/site/home-illo-conversation.svg
           =================================================FileEnd===============================================================
        -o set files output directory
        -prox set authentification proxy configuration if required, format (username:password:hostname:port)
```        
If nothing was specified, GUI runs.
