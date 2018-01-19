#!/usr/bin/env perl

use strict;
use warnings;

my @strs = ("a", "b", "cd", "efg", "aa", "aaa", "aab", "abs");

print "int[] thumbIds = {";
my $i = 1;
foreach (@strs) {
    if ($i % 2) {
        print "\n    R.id.$_, ";
    } else {
        print "R.id.$_";
    }
    
    $i ++;
}
print "\n}\n";
