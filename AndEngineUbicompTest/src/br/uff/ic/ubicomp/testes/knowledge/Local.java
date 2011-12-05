package br.uff.ic.ubicomp.testes.knowledge;


public class Local extends ResourceAgent{

	private String name;

	//espaço é retratado em termo de retangulos
	private Position vertex0; //vértice inferior esquerda
	private Position vertexF; //vértice superior direita

	public Local (String URN, String URL, Position vertex0, Position vertexF)
	{
            super(URN, URL);
            this.name = name;
            this.vertex0= vertex0;
            this.vertexF= vertexF;
	}

	public boolean isInner(Position position) {
		if ((position.getX()>vertex0.getX()) && (position.getX()<vertexF.getX()))
			return (position.getY()>vertex0.getY()) && (position.getY()<vertexF.getY());
		return false;
	}

}


