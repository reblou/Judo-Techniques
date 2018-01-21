#!/usr/bin/env perl

use strict;
use warnings;

open(my $file1, "<", "ikkyo.txt");
open(my $file2, "<", "nikkyo.txt");
open(my $file3, "<", "sankyo.txt");
open(my $file4, "<", "yonkyo.txt");
open(my $file5, "<", "gokyo.txt");

my @lines1 = <$file1>;
my @lines2 = <$file2>;
my @lines3 = <$file3>;
my @lines4 = <$file4>;
my @lines5 = <$file5>;
#my @in = (\@lines1, \@lines2, \@lines3, \@lines4, \@lines5);
my @in = (\@lines1);

# to remove dead links
