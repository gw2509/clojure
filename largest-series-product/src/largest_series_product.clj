(ns largest-series-product
  (:require [clojure.string :as str]))

(defn valid-args?
  [span s]
  (cond
    (neg? span)
    (throw (IllegalArgumentException. "span must not be negative"))

    (> span (count s))
    (throw (IllegalArgumentException. "span must not exceed string length"))

    (some? (re-find #"[^0-9]" s))
    (throw (IllegalArgumentException. "digits input must only contain digits")))

  :else true)

(defn largest-product
  "Returns the largest product of any consecutive digits of length span
  in the string s."
  [span s]
  (if (valid-args? span s)
    (let [input (-> s
                    (str/split #"")
                    (->> (map parse-long)))]
      (->> input
           (partition span 1)
           (map #(apply * %))
           (apply max)))))

(defn largest-product
  [span s]
  (when (valid-args? span s)
    (->> s
         (re-seq #"\d")
         (map #(Integer/parseInt %))
         (partition span 1)
         (map #(apply * %))
         (apply max))))


