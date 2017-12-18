# Algorithms (the original forked repository)
Solutions to the exercises of the Algorithms book by Robert Sedgewick and Kevin Wayne (4th editon).

More information about the original repository at its github homepage:

https://github.com/reneargento/algorithms-sedgewick-wayne

But **please also read the License Notice below** 

# The purpose of this fork
There are lots of algorithms in the forked project, but the algorithm I was interested in is the "k shortest paths":
https://github.com/reneargento/algorithms-sedgewick-wayne/blob/master/src/chapter4/section4/KShortestPaths.java

The purpose of the fork was to make it easy usable as an Adapter implementation in the following project:  
https://github.com/TomasJohansson/adapters-shortest-paths

Therefore I created Maven pom file in the fork, which did not exist in the original/forked project.

I have not changed the directory structure, since it would make it less convenient to merge updated code (e.g. potential future improvements or bug fixes) into my fork. 

Therefore the pom file specifies non-standard directories for source files instead of the standard Maven directories "src/main/java" and "src/test/java".

Also, I created a test method for the "KShortestPaths" class, but otherwise I do not have any more plans for further modifications in this fork of mine.   

# License Notice
This github repository is a fork of the above mentioned repository which is licensed as MIT:

https://github.com/reneargento/algorithms-sedgewick-wayne/blob/master/LICENSE

In this fork, I do NOT want to change that above linked MIT license, but would just like to mention that I **believe** (not being a license expert) that if you want to use this fork (or the forked MIT project for that matter) then your project must (as far as I understand licensing) be licensed as or compatible with GPLv3.

The reason for that is that some code from package "edu.princeton.cs.algs4" is being used.

In the original project (which was non-Maven when I forked it), that package was distributed in a jarfile "libs/algs4.jar" while I am instead using Maven and use jitpack for referring to the dependency in the Maven pom file.

The URL for the "edu.princeton.cs.algs4" repository licensed as GPLv3 which you can see at its github homepage:     
https://github.com/kevin-wayne/algs4/   

The code at the above github URL is based on a book.
From the above github webpage you can follow a link to the following webpage:
https://algs4.cs.princeton.edu/code/

This is a quote from that webpage, which is **relevant regarding licensing**:

*"The library algs4.jar is released under the GNU General Public License, version 3 (GPLv3). If you wish to license the code under different terms, please contact us to discuss."*
