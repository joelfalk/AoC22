(ns day5.solution
  (:require [clojure.string :as str]))


(def demo-input
  "    [D]    \n[N] [C]    \n[Z] [M] [P]\n 1   2   3 \n\nmove 1 from 2 to 1\nmove 3 from 1 to 3\nmove 2 from 2 to 1\nmove 1 from 1 to 2")

(def aoc-input
  (slurp "src/day5/input.txt"))

(defn transpose [m]
  (apply mapv str m))

(def crates-map
  (into [] (for [column (transpose (str/split (first (str/split demo-input #"\n\n")) #"\n"))
                 :let [crates (re-find #"[A-Z]+" column)]
                 :when crates]
             (apply vector crates))))

;move [0] from [1] to [2]
(def rearrangement-procedure
  (into [] (for [strings (let [re-seq-procedures (for [x (str/split (second (str/split demo-input #"\n\n")) #"\n")]
                                                   (re-seq #"move (\d+) from (\d+) to (\d+)" x))]
                           (->> re-seq-procedures
                                (apply concat)
                                (mapv rest)))
                 :let [numbers (map read-string strings)]]
             (mapv into numbers))))


(comment
  ;a)
  ;(for [instruction rearrangement-procedure]
   ; (conj (nth crates-map (last instruction)) (take (first instruction) (nth crates-map (nth instruction 1)))))
  ;b)
  )