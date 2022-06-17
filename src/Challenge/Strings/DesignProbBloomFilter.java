package Challenge.Strings;
/*
discovered by last name bloom
It is a data structure . It is a probabilistic (not deterministic) Data Structure
How does HashMap works

HashMap Key and value exists in a hashmap (HashMap.contains(key1)
Hash Function will compute hash of key to a hashcode
hashcode converted into a bucket using modulus operator(cpu intensive)
(for performance we use shift operator)
This gets us a bucket

internally everything is an array
BST or linked list is used to get the bucket and then compares
the bucket with the key


Bloom Filter unlike HashMap which uses only one hash
Compact data structure
Does not give 100% correctly - so there is false positive but there
 is no false negative

When key is given it passes through multiple hashing algorithms
If it says it exists then it could not, but if it says it does not exists, it does not exist

- Constrained memory
- Avoid unnecessary disc operations

Hoe Bloom works

Series of hash functions
It foes into set of bits 0 1 0 1 1

Will use multiple hash algorithms for a given key
say example
MD5(key1) = int% n
SHA1(key1) = int % n
set the bits  put()
0   1  0   1  0 0 1  0 0

Same hashing algorithm
if bits matches then key exists
contains(key1)


uses

Key Value NoSQL DB
Exist? yes ---->   Bloom Filter ----> No SQL Db
Exists? no ----->  Bloom Filter


Chrome - Phishing website
Bloom filter - If Phising dont go to cloud
N=Bloom Filter - if non phishing --> go to cloud

Memory efficiency of Bloom Filter
---------------------------------
Bloom Filter Wikipedia

memory 15% size of error-free Hashmap
10 bits per element for a just 1% false positive rate

Bloom error 150MB vs 1GB of error-free HashMAp
also eliminates 85% of disk access
 */
public class DesignProbBloomFilter {
}
