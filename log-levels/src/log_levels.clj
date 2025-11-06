(ns log-levels
  (:require [clojure.string :as str]))


(defn- parse-log-line
  "Takes a log line string and returns a map containing the log level and message.
   The log line format should be '[LEVEL]: MESSAGE'"
  [s]
  (let [[level-part message-part] (str/split s #":" 2)]
    {:level   (subs (first (str/split level-part #"]")) 1)
     :message (str/trim message-part)}))


(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (:message (parse-log-line s)))


(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (-> s
      parse-log-line
      :level
      str/lower-case))


(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (let [{:keys [level message]} (parse-log-line s)]
    (str message " (" (str/lower-case level) ")")))

