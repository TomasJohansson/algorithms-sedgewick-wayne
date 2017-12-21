# Algorithms (the original forked repository)
Solutions to the exercises of the Algorithms book by Robert Sedgewick and Kevin Wayne (4th editon).

More information about the original repository at its github homepage:

<https://github.com/reneargento/algorithms-sedgewick-wayne>

But **please also read the License Notice below** 

# License Notice
As far as I understand licensing (not being an expert) this repository must be licensed as GPLv3.

This github repository is a fork of the above mentioned repository which is licensed as MIT:<br>
<https://github.com/reneargento/algorithms-sedgewick-wayne/blob/master/LICENSE>

I like permissive licenses and in this fork I would not want to change the above mentioned and linked MIT license.
However, I **believe** that the license must be considered as GPLv3 since there is a dependency to a GPLv3 library.<br>
Therefore I think that you may not be allowed to use this library in a closed source project or a commercial project.  
(but if you want to, then please keep reading and try to contact the authors of the "algs4" library with a GPLv3 license)  

The forked project ("reneargento/algorithms-sedgewick-wayne") uses some code from the package "edu.princeton.cs.algs4".

In the original project (which was non-Maven when I forked it), that package was distributed in a jarfile "libs/algs4.jar" while I am instead using Maven and use jitpack for referring to the dependency in the Maven pom file.

The "edu.princeton.cs.algs4" repository is licensed as GPLv3 which you can see at its github homepage:<br>     
<https://github.com/kevin-wayne/algs4/>   

The code at the above github URL is based on a book.
From the above github webpage you can follow a link to the following webpage:<br>
<https://algs4.cs.princeton.edu/code/>

This is a quote from that webpage, which is **relevant regarding licensing**:

*"The library algs4.jar is released under the GNU General Public License, version 3 (GPLv3). If you wish to license the code under different terms, please contact us to discuss."*

# The purpose of this fork
There are lots of algorithms in the forked project, but the algorithm I was interested in is the "k shortest paths":<br>
<https://github.com/reneargento/algorithms-sedgewick-wayne/blob/master/src/chapter4/section4/KShortestPaths.java>

The purpose of the fork was to make it easy usable as an Adapter implementation in the following project:<br>  
<https://github.com/TomasJohansson/adapters-shortest-paths>

Therefore I created a Maven pom file in the fork, which did not exist in the original/forked project.

I have not changed the directory structure, since it would make it less convenient to merge updated code (e.g. potential future improvements or bug fixes) into my fork. 

Therefore the pom file specifies non-standard directories for source files instead of the standard Maven directories "src/main/java" and "src/test/java".

I have also created a test method for the "KShortestPaths" class.<br>
Otherwise I have not done any more changes and neither do I have any more plans for further modifications in this fork of mine.   
