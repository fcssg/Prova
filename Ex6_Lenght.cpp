#include <stdio.h>

int TamanhoTexto(char* txt);

int main(int argc, char* argv[]) {
	
	char texto[200];			
	printf("Insira um texto: ");
	scanf("%s", texto );
	printf("Texto: %s\n", texto);
	int tamanho = TamanhoTexto(texto);
	printf("Tamanho: %d\n", tamanho );
	
}

int TamanhoTexto(char* txt) {
	int tlenght = 0;
	while( txt[tlenght] != 0 ) {
		tlenght++;
	}
	return tlenght;
}
