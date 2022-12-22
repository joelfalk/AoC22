(ns day4.solution
  (:require [clojure.string :as str]))


(def demo-input
  "2-4,6-8
  2-3,4-5
  5-7,7-9
  2-8,3-7
  6-6,4-6
  2-6,4-8")

(def aoc-input
  (slurp "src/day4/input.txt"))

(defn split-lines
  [input]
  (let [x (str/split input #"\n *")]
    (for [lines x]
      (str/split lines #","))))

(defn split-to-vectors
  [input]
  (for [z (split-lines input)]
    (let [x (for [y z]
              (str/split y #"-"))]
      (->> x
           (flatten)
           (mapv read-string)))))

(defn check-overlap1
  [x]
  (if (<= (first x) (nth x 2))
    (if (>= (second x) (last x))
      true
      false)
    false))

(defn check-overlap2
  [x]
  (if (>= (first x) (nth x 2))
    (if (<= (second x) (last x))
      true
      false)
    false))

(defn overlaps?
  [x]
  (or
    (check-overlap1 x)
    (check-overlap2 x))
  )

(defn no-overlap?
  [x]
  (or
    (< (second x) (nth x 2))
    (> (first x) (last x))
    ))


  (comment


    ;a)
    (count (filter true? (map overlaps? (split-to-vectors aoc-input))))

    ;b)
    (count (remove true? (map no-overlap? (split-to-vectors aoc-input))))
    )