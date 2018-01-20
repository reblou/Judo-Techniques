#!/usr/bin/env perl

use strict;
use warnings;

#get urls for videos of each technique
#video code
#thumbnail
#title

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
my @in = (\@lines1, \@lines2, \@lines3, \@lines4, \@lines5);
#my @in = (\@lines1);


my $outputFile;

foreach (@in) {
    parseLines(@{$_});
}

sub encode {
    my $code = shift;

    my @chars = split //, $code;
    my @enc;

    push @enc, "i";
    foreach (@chars) {

        if ($_ =~ /[A-Z]/) {
            push @enc, "_" . lc($_);
        } elsif ($_ =~ /_/) {
            push @enc, "_" . $_;
        } elsif ($_ =~ /-/) {
            push @enc, "_0";
        } else {
            push @enc, $_;
        }
    }

    my $str = join //, @enc;
    return $str;
}

sub getThumbnail {
    my $code = shift;
    $code =~ s/\?t=[\s\S]+//g;
    my $s = "https://img.youtube.com/vi/";
    my $end = "/hqdefault.jpg";
    my $url = $s . $code . $end;
    my $filename = encode($code);
    #my $options = "script_output/images/" . $code . ".jpg";
    my $options = "app/src/main/res/drawable/" . $filename . ".jpg";

    unless (-e $options) {
        system("wget", $url, "-O", $options);
        if ($? == -1) {
            print "error: $!\n";
        }
    }

}

sub parseLines {
    my @lines = @_;
    # Get an array of technique names;
    (my $techs = $lines[4]) =~ s/\s+//g;
    my @techniques = split /,/, $techs;
    my $index = 10;
    my $link = "";
    my $n = 1;

    foreach (@techniques) {
        my @links = getGoodLinks($n++, @lines);
        #open($outputFile, ">", "script_output/" . $_ . ".txt");
        open($outputFile, ">", "app/src/main/assets/" . $_ . ".txt");
        foreach my $link (@links) {
            $link = getVideoCode($link);
            if ($link) {
                getThumbnail($link);
                print $outputFile $link . "\n";
            }
        }
    }
}

sub getGoodLinks {
    my ($technique, @lines) = @_;
    my $i = 5;
    my @links;
    my $link;

    my $re = $technique . ". ";
    while($i < @lines && $lines[$i] !~ /^$re/) {
        $i++;
    }
    $i += 4;
    while ($i < @lines && $lines[$i] !~ /^Bad examples/) {
        ($link = $lines[$i]) =~ s/(\s+$)|( [\s\S]+)//g;
        push @links , $link;
        $i += 2;
    }
    return @links;
}

sub getVideoCode {
    my $url = shift;
    my $code = $url;

    if ($code =~ /youtube\.com/) {
        $code =~ s/[\s\S]+\?v=//g;
    } elsif ($code =~ /youtu\.be/) {
        $code =~ s/[\s\S]+be\///g;
    } else {
        $code = "";
    }

    return $code;
}
