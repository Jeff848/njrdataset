/* Generated By:JJTree&JavaCC: Do not edit this line. SXLParserTokenManager.java */
package com.miguel.sxl;

/** Token Manager. */
public class SXLParserTokenManager implements SXLParserConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x77fff000000000L) != 0L)
         {
            jjmatchedKind = 55;
            return 21;
         }
         if ((active0 & 0x8000000000000L) != 0L)
         {
            jjmatchedKind = 55;
            return 9;
         }
         if ((active0 & 0x10000L) != 0L)
            return 23;
         return -1;
      case 1:
         if ((active0 & 0x7e6fe000000000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 55;
               jjmatchedPos = 1;
            }
            return 21;
         }
         if ((active0 & 0x1901000000000L) != 0L)
            return 21;
         return -1;
      case 2:
         if ((active0 & 0x6c1000000000L) != 0L)
            return 21;
         if ((active0 & 0x7e03e000000000L) != 0L)
         {
            jjmatchedKind = 55;
            jjmatchedPos = 2;
            return 21;
         }
         return -1;
      case 3:
         if ((active0 & 0x5202e000000000L) != 0L)
            return 21;
         if ((active0 & 0x2c010000000000L) != 0L)
         {
            jjmatchedKind = 55;
            jjmatchedPos = 3;
            return 21;
         }
         return -1;
      case 4:
         if ((active0 & 0x8010000000000L) != 0L)
         {
            jjmatchedKind = 55;
            jjmatchedPos = 4;
            return 21;
         }
         if ((active0 & 0x24000000000000L) != 0L)
            return 21;
         return -1;
      case 5:
         if ((active0 & 0x10000000000L) != 0L)
            return 21;
         if ((active0 & 0x8000000000000L) != 0L)
         {
            jjmatchedKind = 55;
            jjmatchedPos = 5;
            return 21;
         }
         return -1;
      case 6:
         if ((active0 & 0x8000000000000L) != 0L)
         {
            jjmatchedKind = 55;
            jjmatchedPos = 6;
            return 21;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         return jjMoveStringLiteralDfa1_0(0x400000L);
      case 35:
         return jjStopAtPos(0, 32);
      case 40:
         return jjStopAtPos(0, 26);
      case 41:
         return jjStopAtPos(0, 27);
      case 42:
         return jjStopAtPos(0, 15);
      case 43:
         return jjStopAtPos(0, 13);
      case 44:
         return jjStopAtPos(0, 25);
      case 45:
         return jjStopAtPos(0, 14);
      case 47:
         return jjStartNfaWithStates_0(0, 16, 23);
      case 58:
         return jjStopAtPos(0, 23);
      case 59:
         return jjStopAtPos(0, 24);
      case 60:
         jjmatchedKind = 18;
         return jjMoveStringLiteralDfa1_0(0x400000000100000L);
      case 61:
         jjmatchedKind = 12;
         return jjMoveStringLiteralDfa1_0(0x200000L);
      case 62:
         jjmatchedKind = 17;
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x200000000000L);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x4000000000L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x8000000000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x2000000000000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x8000000000000L);
      case 104:
         return jjMoveStringLiteralDfa1_0(0x40000000000000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x1801000000000L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x80000000000L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x400000000000L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x100000000000L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x10002000000000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x50000000000L);
      case 117:
         return jjMoveStringLiteralDfa1_0(0x20000000000L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x24000000000000L);
      case 123:
         return jjStopAtPos(0, 28);
      case 125:
         return jjStopAtPos(0, 29);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 45:
         if ((active0 & 0x400000000000000L) != 0L)
            return jjStopAtPos(1, 58);
         break;
      case 61:
         if ((active0 & 0x80000L) != 0L)
            return jjStopAtPos(1, 19);
         else if ((active0 & 0x100000L) != 0L)
            return jjStopAtPos(1, 20);
         else if ((active0 & 0x200000L) != 0L)
            return jjStopAtPos(1, 21);
         else if ((active0 & 0x400000L) != 0L)
            return jjStopAtPos(1, 22);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000000000000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x100c2000000000L);
      case 102:
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 48, 21);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x4008000000000L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000000000000L);
      case 110:
         if ((active0 & 0x800000000000L) != 0L)
         {
            jjmatchedKind = 47;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x221000000000L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x404000000000L);
      case 114:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 44, 21);
         return jjMoveStringLiteralDfa2_0(active0, 0x20000000000000L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000000000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000000000000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000a000000000L);
      case 100:
         if ((active0 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 45, 21);
         break;
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x24020000000000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000000000000L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000000000000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000000000L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000000000000L);
      case 116:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 36, 21);
         else if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 42, 21);
         else if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 43, 21);
         else if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 46, 21);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000000000L);
      case 100:
         if ((active0 & 0x10000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 52, 21);
         break;
      case 101:
         if ((active0 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 49, 21);
         break;
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000000L);
      case 108:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 37, 21);
         else if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 38, 21);
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000000000L);
      case 114:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 39, 21);
         break;
      case 116:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 41, 21);
         else if ((active0 & 0x40000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 54, 21);
         return jjMoveStringLiteralDfa4_0(active0, 0x20000000000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 50, 21);
         else if ((active0 & 0x20000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 53, 21);
         break;
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000000000L);
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000000000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 103:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 40, 21);
         break;
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000000000000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 111:
         return jjMoveStringLiteralDfa7_0(active0, 0x8000000000000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 110:
         if ((active0 & 0x8000000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 51, 21);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 42;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 30)
                        kind = 30;
                     jjCheckNAddStates(0, 2);
                  }
                  else if ((0x100002600L & l) != 0L)
                  {
                     if (kind > 2)
                        kind = 2;
                  }
                  else if (curChar == 47)
                     jjAddStates(3, 4);
                  else if (curChar == 39)
                     jjCheckNAddStates(5, 7);
                  else if (curChar == 34)
                     jjCheckNAddStates(8, 10);
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 9:
               case 21:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 55)
                     kind = 55;
                  jjCheckNAdd(21);
                  break;
               case 23:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(29, 30);
                  else if (curChar == 47)
                     jjCheckNAddStates(11, 13);
                  break;
               case 1:
                  if (curChar == 10 && kind > 2)
                     kind = 2;
                  break;
               case 2:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 11:
                  if (curChar == 34)
                     jjCheckNAddStates(8, 10);
                  break;
               case 12:
                  if ((0xffffff7b00000000L & l) != 0L)
                     jjCheckNAddStates(8, 10);
                  break;
               case 14:
                  if (curChar == 34 && kind > 34)
                     kind = 34;
                  break;
               case 15:
                  if (curChar == 39)
                     jjCheckNAddStates(5, 7);
                  break;
               case 16:
                  if ((0xffffff7b00000000L & l) != 0L)
                     jjCheckNAdd(17);
                  break;
               case 17:
                  if (curChar == 39 && kind > 35)
                     kind = 35;
                  break;
               case 19:
                  if (curChar == 39)
                     jjCheckNAdd(17);
                  break;
               case 22:
                  if (curChar == 47)
                     jjAddStates(3, 4);
                  break;
               case 24:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     jjCheckNAddStates(11, 13);
                  break;
               case 25:
                  if ((0x100002600L & l) != 0L && kind > 3)
                     kind = 3;
                  break;
               case 26:
                  if (curChar == 10 && kind > 3)
                     kind = 3;
                  break;
               case 27:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 28:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(29, 30);
                  break;
               case 29:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(29, 30);
                  break;
               case 30:
                  if (curChar == 42)
                     jjAddStates(14, 15);
                  break;
               case 31:
                  if ((0xffff7fffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(32, 30);
                  break;
               case 32:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(32, 30);
                  break;
               case 33:
                  if (curChar == 47 && kind > 4)
                     kind = 4;
                  break;
               case 34:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 30)
                     kind = 30;
                  jjCheckNAddStates(0, 2);
                  break;
               case 35:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 30)
                     kind = 30;
                  jjCheckNAdd(35);
                  break;
               case 36:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(36, 37);
                  break;
               case 37:
                  if (curChar == 46)
                     jjCheckNAdd(38);
                  break;
               case 38:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 31)
                     kind = 31;
                  jjCheckNAddTwoStates(38, 39);
                  break;
               case 40:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(41);
                  break;
               case 41:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 31)
                     kind = 31;
                  jjCheckNAdd(41);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 55)
                        kind = 55;
                     jjCheckNAdd(21);
                  }
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 9;
                  else if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 9:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 55)
                        kind = 55;
                     jjCheckNAdd(21);
                  }
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 8;
                  break;
               case 3:
                  if (curChar == 101 && kind > 33)
                     kind = 33;
                  break;
               case 4:
                  if (curChar == 117)
                     jjCheckNAdd(3);
                  break;
               case 5:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 6:
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 7:
                  if (curChar == 115)
                     jjCheckNAdd(3);
                  break;
               case 8:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 10:
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 12:
                  if ((0x7fffffffffffffffL & l) != 0L)
                     jjAddStates(8, 10);
                  break;
               case 13:
                  if (curChar == 92)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 16:
                  if ((0x7fffffffffffffffL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 17;
                  break;
               case 18:
                  if (curChar == 92)
                     jjAddStates(16, 17);
                  break;
               case 20:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 55)
                     kind = 55;
                  jjCheckNAdd(21);
                  break;
               case 21:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 55)
                     kind = 55;
                  jjCheckNAdd(21);
                  break;
               case 24:
                  jjAddStates(11, 13);
                  break;
               case 29:
                  jjCheckNAddTwoStates(29, 30);
                  break;
               case 31:
               case 32:
                  jjCheckNAddTwoStates(32, 30);
                  break;
               case 39:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(18, 19);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 24:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(11, 13);
                  break;
               case 29:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(29, 30);
                  break;
               case 31:
               case 32:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(32, 30);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 42 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   35, 36, 37, 23, 28, 16, 17, 18, 12, 13, 14, 24, 25, 27, 31, 33, 
   16, 19, 40, 41, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, "\75", 
"\53", "\55", "\52", "\57", "\76", "\74", "\76\75", "\74\75", "\75\75", "\41\75", 
"\72", "\73", "\54", "\50", "\51", "\173", "\175", null, null, "\43", null, null, 
null, "\151\156\164", "\162\145\141\154", "\142\157\157\154", "\143\150\141\162", 
"\163\164\162\151\156\147", "\165\156\151\164", "\163\145\164", "\154\145\164", "\157\162", 
"\141\156\144", "\156\157\164", "\151\156", "\151\146", "\145\154\163\145", 
"\167\150\151\154\145", "\146\165\156\143\164\151\157\156", "\162\145\141\144", 
"\167\162\151\164\145", "\150\141\154\164", null, null, null, "\74\55", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x4fffffffffff001L, 
};
static final long[] jjtoSkip = {
   0x1cL, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[42];
private final int[] jjstateSet = new int[84];
protected char curChar;
/** Constructor. */
public SXLParserTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public SXLParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 42; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
