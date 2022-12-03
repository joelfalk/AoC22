(ns test
  (:require [clojure.test]))

(defmacro is= [actual expected]
  `(do
     (let [actual# ~actual
           expected# ~expected
           equal# (= actual# expected#)]
       (when-not equal#
         (println "Actual:\t\t" actual# "\nExpected:\t" expected#))
       (clojure.test/is (= actual# expected#)))))

(defmacro is [form]
  `(do
     (clojure.test/is ~form)))

(defmacro is-not [form]
  `(do
     (clojure.test/is (not ~form))))
