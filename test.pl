#!/usr/bin/env perl

use strict;
use warnings;

my $s = "https://img.youtube.com/vi/";
my $end = "/hqdefault.jpg";
my $code = "GyHA17-59yk";
my $x = $s . $code . $end;
my $options = $code . ".jpg";

system("wget", $x, "-O", $options);
