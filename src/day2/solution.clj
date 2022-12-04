(ns day2.solution
  (:require [clojure.string :as str]))

(def demo-input "A Y
  B X
  C Z")

(def input
  (slurp "src/day2/input.txt"))

; score-board,
; opponent move A = ROCK B = PAPER C = SCISSOR
; protagonist move X = ROCK Y = PAPER Z = SCISSOR
; values is the resulting point
(def score-board-part-1
  {"A X" 4
   "A Y" 8
   "A Z" 3
   "B X" 1
   "B Y" 5
   "B Z" 9
   "C X" 7
   "C Y" 2
   "C Z" 6})

(def score-board-part-2
  {"A X" 3
   "A Y" 4
   "A Z" 8
   "B X" 1
   "B Y" 5
   "B Z" 9
   "C X" 2
   "C Y" 6
   "C Z" 7})

(defn split-lines
  [input]
  (str/split input #"\n *"))

(comment
  ;a)
  (reduce + (for [x (split-lines input)]
              (score-board x)))
  ;b)
  (reduce + (map score-board-part-2 (split-lines input)))
  )


