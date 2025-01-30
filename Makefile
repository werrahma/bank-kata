JAVAC = javac
JAVA = java
SRC_DIR = bankkata
SRCS = $(wildcard $(SRC_DIR)/*.java)
CLASSES = $(SRCS:.java=.class)

all: $(CLASSES)
	@echo "Compilation complete. Running program..."
# @$(JAVA) -cp . bankkata.Main

$(SRC_DIR)/%.class: $(SRC_DIR)/%.java
	@$(JAVAC) -d . $(SRCS)

re: clean all

clean:
	@echo "Cleaning up..."
	@rm -rf $(SRC_DIR)/*.class
