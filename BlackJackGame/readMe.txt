{\rtf1\ansi\ansicpg1252\cocoartf1187\cocoasubrtf340
{\fonttbl\f0\fnil\fcharset0 Monaco;}
{\colortbl;\red255\green255\blue255;\red63\green95\blue191;}
\margl1440\margr1440\vieww16860\viewh13180\viewkind0
\deftab720
\pard\pardeftab720

\f0\fs22 \cf2 /******************************\cf0 \
\cf2 *\cf0   \cf2 BlackJack ReadMe\cf0 \
\cf2 *\cf0   \cf2 written\cf0  \cf2 by\cf0  \cf2 Stuart\cf0  \cf2 Wagner\cf0 \
\cf2 *\cf0   \
\cf2 ********************************/\
\
The game starts by asking you to enter an amount of money between 100 and 100,000 dollars in a multiple of ten. After that, it asks for your bet on your hand with validations. If you have black jack or the dealer has black jack, it will tell you here. After that, if you have the chips to double your bet, you are then asked to double down, which will auto-hit you one card and then make you stand. After that, if you have the chips and the option to split, you are presented it. \
\
Once you get to the hit options, you may hit until you bust or get to 21. Press any key for dealer to go. After that, you, will see who wins and loses and what you win or lose. \
\
Core Assumptions:\
\
1) If you bust in one hand, or if you have two hands and bust them both, dealer will stand and not hit to 17. \
2) If player or dealer have blackjack, the ability to hit will be interrupted unless player has two hands (in which case dealer can hit if player has only one hand with blackjack out of 2)\
3) No negative money, but house has unlimited money to bet\
4) Unless given the option, only enter numbers. The game works with numbers, not strings. \
5) If you run out of money, restart the game to get more in. You cannot add money after starting a hand. \
6) BlackJack pays out 1.5\
\
Dsign comments are within the code, but basically I have the following classes which do the following things:\
\
Game - Plays the game\
Test - Runs game\
Hand - Holds each hand\
Player - Score and has a hand\
Dealer - Deals the deck and plays the game\
Deck - Stores cards\
Card - Object in the deck/hand\
\
I think my code is organized fairly well, although it became a little messy when making split work. If I were to do it again, I'd make each hand an object in an array (instead of instance variables in the Player and Dealer classes). This would allow me to add multiple hands. \
\
Otherwise, I've tested the game (through some tester methods I created allowing me to see how selected hands result) and it appears to work fully. I tried to make it non-breakable, so hopefully you agree!\
\
Also, I learned a bunch during this assignment and I hope it shows! I actually put in a lot of time to this, and I think it shows, but more importantly, I really think i learned to write better code, which is more exciting. }